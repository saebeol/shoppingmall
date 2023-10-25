function scrollToBestItems() {
    const bestItemsSection = document.getElementById('best-items-section');
    if (bestItemsSection) {
        // Calculate the position of the "BEST ITEMS" section relative to the viewport
        const offset = bestItemsSection.getBoundingClientRect().top;
        
        // Set the scroll behavior to smooth for a smooth scrolling effect
        window.scrollTo({
            top: offset,
            behavior: 'smooth'
        });
    }
}


function scrollToNewArrivals() {
    const newArrivalsSection = document.getElementById('new-arrivals-section');
    if (newArrivalsSection) {
        // Calculate the position of the "NEW ARRIVALS" section relative to the viewport
        const offset = newArrivalsSection.getBoundingClientRect().top;

        // Set the scroll behavior to smooth for a smooth scrolling effect
        window.scrollTo({
            top: offset,
            behavior: 'smooth'
        });
    }
}


// 카드를 눌렀을때 상세페이지로 넘어가는 스크립트






