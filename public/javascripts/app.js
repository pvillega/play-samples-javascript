/** CUSTOM SCRIPTS HERE */
/**
* Sets the proper selected option in the navbar
*/
function setNavbar(id) {
    //remove all selectors
    $('#menuHome').removeClass('active');
    $('#menuI18n').removeClass('active');
    $('#menuRouting').removeClass('active');
    $('#menuGridster').removeClass('active');
    $('#menuMailcheck').removeClass('active');
    $('#menuSessionjs').removeClass('active');
    $('#menuMarkdown').removeClass('active');
    $('#menuGoogleAnalytics').removeClass('active');
    $('#menuD3js').removeClass('active');
    $('#menuTheJit').removeClass('active');
    $('#menuLessPrefixer').removeClass('active');
    $('#menuGeolocation').removeClass('active');
    $('#menuWebWorkers').removeClass('active');
    $('#menuLocalStorage').removeClass('active');
    $('#menuOffline').removeClass('active');
    $('#menuEmailBoilerplate').removeClass('active');
    $('#menuSemanticElements').removeClass('active');
    $('#menuForms').removeClass('active');

    //set given one
    $("#menu"+id).addClass('active');
}

/** END OF CUSTOM SCRIPTS */

/*!
* Below there are core functional scripts added in here to load less files on request, don't change
*/
/*!
* Allows $(function() {}); to be used even without Jquery loaded - This code fragments runs the stored calls.
* This is useful so we can push all the $(function() { ...}); calls in templates without having to load jquery at head
*/window.$.noConflict();window.$ = window.$.attachReady(jQuery);
/*!
* Prevention of window hijack, run after all jquery scripts
*/$('html').css('display','none');if( self == top ){document.documentElement.style.display = 'block';}else{top.location = self.location;}