
var insurance_tool  =   {
    form_num    :   0,

    addForm     :   function()
    {
        var template = $('#form-template').html();

        insurance_tool.form_num +=  1;
        template   =   template.replace(/%id%/g, insurance_tool.form_num);

        var $template = $(template);
        $('#template').append($template);

        var options =   {minDate: 0};

        $('input[name=startDate]').datepicker(options);
        $('input[name=endDate]').datepicker(options);
    },

    showError   :   function (text)
    {
        $('#error').text(text).show();
        window.scrollTo(0,0);

        setTimeout(function () {
            $('#error').text('').hide();
        }, 5000);
    },

    goToTarget  :   function(target)
    {
        if(target === 'userFormView')
        {
            if($('#template article').length < 1){
                insurance_tool.addForm();
                $('.removeform').remove();
            }
        }

        if(target === 'thanksView')
        {
            if( ! insurance_tool.validateForm())
                return false;

            $('#name').text($('input[name=name][data-id="1"]').val());
        }

        return true;
    },

    validateForm : function()
    {
        try
        {
            $('#template article').each(function()
            {
                var id  =   $(this).data('id');

                if( ! $('input[name=name][data-id='+id+']').val() || $('input[name=name][data-id='+id+']').val().length >= 90)
                    throw {'msg' : 'Please enter your name', 'elt' : 'input[name=name][data-id='+id+']'};

                if( ! $('input[name=address1][data-id='+id+']').val())
                    throw {'msg' : 'Please enter your address', 'elt' : 'input[name=address1][data-id='+id+']'};

                if( ! $('input[name=startDate][data-id='+id+']').val())
                    throw {'msg' : 'Please select the StartDate', 'elt' : 'input[name=startDate][data-id='+id+']'};

                if( ! $('input[name=endDate][data-id='+id+']').val())
                    throw {'msg' : 'Please select the EndDate', 'elt' : 'input[name=endDate][data-id='+id+']'};

                if($('input[name=startDate][data-id='+id+']').val() > $('input[name=endDate][data-id='+id+']').val())
                    throw {'msg' : 'Please select the valid EndDate', 'elt' : 'input[name=endDate][data-id='+id+']'};
            });

            return true;
        }
        catch(err)
        {
            insurance_tool.showError(err.msg);

            $(err.elt).focus();
            return false;
        }
    }
};

$( document ).ready(function() {

    location.hash   =   '#homeView';

    $(window).on('hashchange', function(){
        var hash    =   location.hash;

        if( ! hash)
            hash   =   '#homeView';

        var bc_name =   $('[data-targetview="'+hash.slice(1)+'"]').data('bc-name');

        var tpl = $("<li><a href=" + hash + "> >> " + bc_name + "</a></li>");
        $('#pageLink').append(tpl);

        $('#pageLink a[href="'+hash+'"]').parent('li').nextAll('li').remove();
        $('.view').fadeOut(300);
        $(hash).delay(300).fadeIn(300);
    });

    //Add a form
    $('.addmore').on('click', function(){

        if($('#template article').length >= 5)
        {
            insurance_tool.showError('You cannot add more than 5 persons to your Plan');
            return false;
        }

        insurance_tool.addForm();

        $('.removeform').removeClass('hide');
        var num =   insurance_tool.form_num;

        $('input[name=startDate][data-id='+num+']').val($('input[name=startDate][data-id="1"]').val());
        $('input[name=endDate][data-id='+num+']').val($('input[name=endDate][data-id="1"]').val());

        //Remove a form
        $('.removeform').on('click', function(){
            var id  =   $(this).data('id');
            $('article[data-id='+id+']').remove();
        });
    });

    //On every button click
    $('.taskbar button:not(.addmore, .removeform)').on('click', function(){
        var target      =   $(this).data('targetview');

        if(insurance_tool.goToTarget(target))
            location.hash   =   target;
    });
});