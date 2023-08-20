document.getElementById('signup-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const name = document.getElementById('signup-name').value;
    const age = document.getElementById('signup-age').value;
    const mobile = document.getElementById('signup-mobile').value;
    const dob = document.getElementById('signup-dob').value;
    const gender = document.getElementById('signup-gender').value;
    const country = document.getElementById('signup-country').value;
    const password = document.getElementById('signup-password').value;

    const user = {
      name: name,
      age: age,
      mobile: mobile,
      dob: dob,
      gender: gender,
      country: country,
      password: password
    }

    const url=`http://localhost:8081/users`;
    const xhr = new XMLHttpRequest();
    xhr.open('POST',url);
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.setRequestHeader('Access-Control-Allow-Origin', '*')

    xhr.onreadystatechange = () =>{
      if(xhr.status == 200 && xhr.readyState == 4){
        console.log(xhr.responseText);
        document.location.href=`http://127.0.0.1:5500/frontend/html/`;
      }
    }

    // Request body is senr while callind xhr.send(), but in JSON format.
    xhr.send( JSON.stringify(user) );
  });
  