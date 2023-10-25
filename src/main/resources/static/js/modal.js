document.addEventListener('DOMContentLoaded', () => {
    const closeModalBtn = document.getElementById('closeModalBtn');
    const modal = document.getElementById('myModal');

    modal.style.display = 'block';

    closeModalBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    window.addEventListener('click', (e) => {
        if (e.target === modal) {
            modal.style.display = 'none';
        }
    });
});