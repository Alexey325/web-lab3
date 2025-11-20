window.addEventListener('load', function() {

    canvas.addEventListener('click', (event) => {

        const rInput = document.querySelector('#mainForm\\:r_input');

        // console.log(rInput)
        // console.log(rInput.value)
        // console.log(parseFloat(rInput.value.replace(',', '.')))

        const rect = canvas.getBoundingClientRect();

        const canvasX = event.clientX - rect.left;
        const canvasY = event.clientY - rect.top;

        const xValue = (canvasX - centerX) / 160 * parseFloat(rInput.value.replace(',', '.'));
        const yValue = -(canvasY - centerY) / 160 * parseFloat(rInput.value.replace(',', '.'));

        // console.log(xValue, yValue)

        document.getElementById('mainForm:canvasX').value = xValue;
        document.getElementById('mainForm:canvasY').value = yValue;

        submitPointFromCanvas();

    })

})