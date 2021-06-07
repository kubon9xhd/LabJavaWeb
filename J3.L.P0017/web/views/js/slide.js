/*slide*/
var slides = document.querySelectorAll('.slide');
var currentSlide = 0;
var slideInterval = setInterval(nextSlide, 1000);

function nextSlide() {
    slides[currentSlide].className = 'slide';
    currentSlide = (currentSlide + 1) % slides.length;
    slides[currentSlide].className = 'slide active';
}

var playing = true;
var pauseButton = document.getElementById('pause');

function pauseSlideshow() {
    pauseButton.innerHTML = 'Play';
    playing = false;
    clearInterval(slideInterval);
}

function playSlideshow() {
    pauseButton.innerHTML = 'Pause';
    playing = true;
    slideInterval = setInterval(nextSlide, 1000);
}

pauseButton.onclick = function () {
    if (playing) {
        pauseSlideshow();
    } else {
        playSlideshow();
    }
};

