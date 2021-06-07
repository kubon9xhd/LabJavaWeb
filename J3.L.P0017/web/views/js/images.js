// Get the modal
var modal = document.getElementById("myModal");
// Get the image and insert it inside the modal - use its "alt" text as a caption
var modalImg = document.getElementById("img01");
var body = document.getElementsByTagName("body");
document.querySelectorAll("#myImg").forEach(myImg => {
    myImg.addEventListener('click', () => {
        modal.style.display = "block";
        modalImg.src = myImg.src;
        body.style.overflow = "hiden";
        // console.log("Oke");
    });
});
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}
function myDropDown() {
    var btnMenu = document.getElementsByClassName("nav-link");
    if(btnMenu[1].classList[1] != "show"){
        btnMenu[1].style.display = "block";
        btnMenu[1].classList.add("show");
    }else{
        btnMenu[1].style.display = "none";
        btnMenu[1].classList.remove("show");
    }
}
