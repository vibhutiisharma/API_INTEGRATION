
document.getElementById('loginForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const loginId = document.getElementById('loginId').value;
  const password = document.getElementById('password').value;

 
});

document.getElementById('createCustomerForm').addEventListener('submit', function (event) {
  event.preventDefault();
 
});

document.getElementById('deleteCustomerForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const deleteUuid = document.getElementById('deleteUuid').value;

});

document.getElementById('updateCustomerForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const updateUuid = document.getElementById('updateUuid').value;
 
});


function displayCustomerList(customers) {
  
}
