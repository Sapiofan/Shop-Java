
// const buttonsWrapper = document.querySelector(".map");
// const slides = document.querySelector(".inner");

// buttonsWrapper.addEventListener("click", e => {
//   if (e.target.nodeName === "BUTTON") {
//     Array.from(buttonsWrapper.children).forEach(item =>
//       item.classList.remove("active")
//     );
//     if (e.target.classList.contains("first")) {
//       slides.style.transform = "translateX(-0%)";
//       e.target.classList.add("active");
//     } else if (e.target.classList.contains("second")) {
//       slides.style.transform = "translateX(-33.33333333333333%)";
//       e.target.classList.add("active");
//     } else if (e.target.classList.contains('third')){
//       slides.style.transform = 'translatex(-66.6666666667%)';
//       e.target.classList.add('active');
//     }
//   }
// });

var slideIndex = 0;
showSlides();
function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for(i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if(slideIndex > slides.length) {
        slideIndex = 1
    }
    slides[slideIndex - 1].style.display = "block";
    setTimeout(showSlides, 8000); // Change image every 2 seconds
}
