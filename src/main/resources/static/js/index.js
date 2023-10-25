document.querySelector('.logo a').addEventListener('click', function() {
    window.location.href = './index.html';
});
 
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}