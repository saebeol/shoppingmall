
 const quantityInputs = document.querySelectorAll('.quantity');


 quantityInputs.forEach(input => {
     input.addEventListener('input', updateTotalPrice);
 });


 function updateTotalPrice() {
     let totalPrice = 0;
     quantityInputs.forEach(input => {
         const quantity = parseInt(input.value);
         if (!isNaN(quantity) && quantity >= 1) {
             const pricePerItem = parseFloat(input.dataset.price); 
             totalPrice += quantity * pricePerItem;
         }
     });


     const totalInput = document.querySelector('input[readonly]');
     if (totalInput) {
         totalInput.value = totalPrice.toFixed(2); 
     }
 }


 function removeItem(button) {
     const row = button.closest('tr');
     row.remove();
     updateTotalPrice(); 
 }


 const deleteButtons = document.querySelectorAll('.btn-dark');
 deleteButtons.forEach(button => {
     button.addEventListener('click', () => {
         removeItem(button);
     });
 });


 function emptyCart() {
    const cartTable = document.querySelector('.table');
    if (cartTable) {
        const tableRows = cartTable.querySelectorAll('tbody tr'); 
        tableRows.forEach(row => {
            row.innerHTML = ''; 
        });
        updateTotalPrice(); 
    }
}


 const emptyCartButton = document.querySelector('.btn-light');
 if (emptyCartButton) {
     emptyCartButton.addEventListener('click', emptyCart);
 }