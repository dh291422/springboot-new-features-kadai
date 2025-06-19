const stripe = Stripe('pk_test_51RVNkqB6eHNhnOUx4io8IWreTTicDsv5GRq6BP9NfOKxDOcVZL1Wr1exQwWVS8VJRgJLNJxPHvOXhjaYJnQrbI7x00kTUESUPU');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});