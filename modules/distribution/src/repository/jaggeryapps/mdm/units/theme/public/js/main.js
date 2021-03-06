$( document ).ready(function() {

    $('[data-toggle="tooltip"]').tooltip();

    $("[data-toggle=popover]").popover();

    $(".ctrl-asset-type-switcher").popover({
        html : true,
        content: function() {
            return $('#content-asset-types').html();
        }
    });

    $(".ctrl-filter-type-switcher").popover({
        html : true,
        content: function() {
            return $('#content-filter-types').html();
        }
    });

    $('#nav').affix({
        offset: {
            top: $('header').height()
        }
    });
}); 