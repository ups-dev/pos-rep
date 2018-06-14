function handleHotKey(id) {
    var jqButton = jQuery('#' + id.replace(/:/g, "\\:"));
    if (jqButton.attr('disabled') !== 'disabled') {
        jqButton.trigger("click");
    }
}

function handleHotKeyPag(id, children) {
    var jqButton = jQuery('#' + id.replace(/:/g, "\\:"));
    var jqChildren = jqButton.children("." + children);
    if (!jqChildren.hasClass("ui-state-disabled")) {
        jqChildren.trigger("click");
    }
}

function handleSubmit(xhr, status, args, dialog) {
    if (args && args.validationFailed) {
        PF('saveButtonWV').enable();
        var jqDialog = jQuery('#' + dialog.id.replace(/:/g, "\\:"));
        var intShakes = 1;
        var intDistance = 10;
        var intDuration = 100;
        var left = parseInt(jqDialog.css("left"));
        if (jqDialog.is(':animated')) {
            return;
        }
        for (var x = 1; x <= intShakes; x++) {
            jqDialog.animate({left: (left + intDistance) + 'px'}, (((intDuration / intShakes) / 2)))
                    .animate({left: (left + (intDistance * -1)) + 'px'}, ((intDuration / intShakes) / 4))
                    .animate({left: left + 'px'}, (((intDuration / intShakes) / 4)));
        }
    } else {
        dialog.hide();
    }
}

//PrimeFaces.widget.SelectOneMenu.prototype.init = function(init) {
//    return function() {
//        init.apply(this, arguments);
//        var panelClick = this;
//        panelClick.focusInput.bind("focus", function(e) {
//            if (panelClick.panel.is(':hidden'))
//                panelClick.show();
//        });
//    };
//}(PrimeFaces.widget.SelectOneMenu.prototype.init);

PrimeFaces.widget.InputText.prototype.init = function(init) {
    return function() {
        init.apply(this, arguments);
        this.jq.keypress(function(e) {
            var charCode = (typeof e.which == "number") ? e.which : e.keyCode;
            if (charCode === 10 || charCode === 13) {
                e.preventDefault();
            }
        });
    };
}(PrimeFaces.widget.InputText.prototype.init);

function NumCheck(e, field) {
    key = e.keyCode ? e.keyCode : e.which
    if ((key == 8) || (key == 9) || (key == 46) || (key == 27))
        return true
    if (key > 47 && key < 58) {
        if (field.value == "")
            return true
        regexp = /.[0-9]{2}$/
        return !(regexp.test(field.value))
    }
    if ((key > 34) && (key < 40)) {
        return true
    }
    return false
}
function NumCheckDecimal(e, field){
     key = e.keyCode ? e.keyCode : e.which
    if ((key == 8) || (key == 9) || (key == 46) || (key == 27))
        return true;
    if (key > 47 && key < 58) {
        if (field.value == "")
            return true;
        regexp = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
        return !(regexp.test(field.value))
    }
    if ((key > 34) && (key < 40)) {
        return true
    }
    return false
}

function NumTelefono(e, field) {
    key = e.keyCode ? e.keyCode : e.which
    // backspace
    if ((key == 8) || (key == 9) || (key == 27) || (key == 32) || (key == 35) || (key == 36) || (key == 45))
        return true
    // 0-9
    if (key > 47 && key < 58) {
        if (field.value == "")
            return true
        regexp = /.[0-9]{2}$/
        return !(regexp.test(field.value))
    }
    // .
    if ((key > 34) && (key < 40)) {
        return true
    }
    // other key
    return false
}
