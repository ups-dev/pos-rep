function handleSubmit(xhr, status, args, dialog) {
    if (!args?.validationFailed) {
        dialog.hide();
    }
}

if (PrimeFaces.widget.InputText) {
    PrimeFaces.widget.InputText.prototype.init = function (init) {
        return function () {
            init.apply(this, arguments);
            this.jq.keypress(function (e) {
                var charCode = (typeof e.which == "number") ? e.which : e.keyCode;
                if (charCode === 10 || charCode === 13) {
                    e.preventDefault();
                }
            });
        };
    }(PrimeFaces.widget.InputText.prototype.init);
}

if (PrimeFaces.widget.InputNumber) {
    PrimeFaces.widget.InputNumber.prototype.init = function (init) {
        return function () {
            init.apply(this, arguments);
            this.jq.keydown(function (e) {
                if (e.keyCode === 10 || e.keyCode === 13) {
                    e.preventDefault();
                }
            });
        };
    }(PrimeFaces.widget.InputNumber.prototype.init);
}
