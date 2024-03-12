// 슬라이드의 현재 인덱스를 저장합니다.
var currentSlide = 0;

// 슬라이드를 자동으로 전환합니다.
setInterval(function() {
    currentSlide++;
    if (currentSlide >= 3) {
        currentSlide = 0;
    }

    // 현재 슬라이드를 표시합니다.
    document.querySelector(".slides li").style.display = "none";
    document.querySelector(".slides li:nth-child(" + currentSlide + ")").style.display = "block";
}, 3000);

// 이전 슬라이드로 이동합니다.
function previousSlide() {
    currentSlide--;
    if (currentSlide < 0) {
        currentSlide = 2;
    }

    // 현재 슬라이드를 표시합니다.
    document.querySelector(".slides li").style.display = "none";
    document.querySelector(".slides li:nth-child(" + currentSlide + ")").style.display = "block";
}

// 다음 슬라이드로 이동합니다.
function nextSlide() {
    currentSlide++;
    if (currentSlide >= 3) {
        currentSlide = 0;
    }

    // 현재 슬라이드를 표시합니다.
    document.querySelector(".slides li").style.display = "none";
    document.querySelector(".slides li:nth-child(" + currentSlide + ")").style.display = "block";
}