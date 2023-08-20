document.getElementById('signin-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const mobile = document.getElementById('signin-mobile').value;
    const password = document.getElementById('signin-password').value;

    const userlogin = {
      mobile: mobile,
      password: password
    }

    const url=`http://localhost:8081/login`;
    const xhr = new XMLHttpRequest();
    xhr.open('POST',url);
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.setRequestHeader('Access-Control-Allow-Origin', '*')

    xhr.onreadystatechange = () =>{
      if(xhr.status == 200 && xhr.readyState == 4){
        console.log(xhr.responseText);
        if(xhr.responseText === `null`){
          alert(`Wrong Mobile or password`)
          }
          
          else{
            document.location.href=`http://127.0.0.1:5500/frontend/html/`;}
            
      }
    }

    // Request body is senr while callind xhr.send(), but in JSON format.
    xhr.send( JSON.stringify(userlogin) );
  });
  