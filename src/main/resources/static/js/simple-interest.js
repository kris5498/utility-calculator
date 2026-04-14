document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".simple-interest-form");
    if (!form) {
        return;
    }

    const modeSelect = form.querySelector(".js-time-mode-select");
    const groups = form.querySelectorAll(".js-time-group");
    const notes = form.querySelectorAll(".js-time-note");
    const errorMessage = document.querySelector(".js-error-message");
    const resultContainer = document.querySelector(".js-result-container");

    function setGroupState(group, isActive) {
        const inputs = group.querySelectorAll("input");
        group.classList.toggle("active", isActive);
        inputs.forEach(function (input) {
            input.required = isActive;
        });
    }

    function clearTimeInputs() {
        groups.forEach(function (group) {
            const inputs = group.querySelectorAll("input");
            inputs.forEach(function (input) {
                input.value = "";
            });
        });
    }

    function clearAllInputs() {
        const inputs = form.querySelectorAll("input");
        inputs.forEach(function (input) {
            input.value = "";
        });
    }

    function hideOutputBlocks() {
        if (errorMessage) {
            errorMessage.style.display = "none";
        }
        if (resultContainer) {
            resultContainer.style.display = "none";
        }
    }

    function applyMode() {
        const mode = modeSelect.value;

        groups.forEach(function (group) {
            setGroupState(group, group.dataset.mode === mode);
        });

        notes.forEach(function (note) {
            note.classList.toggle("active", note.dataset.mode === mode);
        });
    }

    modeSelect.addEventListener("change", function () {
        clearTimeInputs();
        applyMode();
    });

    form.addEventListener("reset", function (event) {
        event.preventDefault();
        clearAllInputs();
        clearTimeInputs();
        hideOutputBlocks();
        applyMode();
    });

    applyMode();
});
