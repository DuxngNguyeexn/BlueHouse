function showPass() {
    var x = document.getElementById("password");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
  function showConfPass() {
    var x = document.getElementById("confPassword");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
  $(document).ready(function() {

   
})
function checkName() {
  var name = $('#username').val();
  if(name == '' ){
      $('#errorName').removeClass('d-none')
      $('#username').css('border','2px solid red');
      return false;
  }else{
      return true
  }
;
}
function checkPass() {
  var password = $('#password').val();
  if(password == ''  ){
      $('#errorPass').removeClass('d-none')
      $('#password').css('border','2px solid red');
      $('#eyePass').css('border','2px solid red');
      return false;
  }else{
      return true
  }
;
}
function checkConfPass() {
  var password = $('#confPassword').val();
  if(password == ''  ){
      $('#errorConfPass').removeClass('d-none')
      $('#confPassword').css('border','2px solid red');
      $('#eyeConfPass').css('border','2px solid red');
      return false;
  }else{
      return true
  }
;
}
function check(){
  checkName();
  checkPass();
  checkConfPass();
}