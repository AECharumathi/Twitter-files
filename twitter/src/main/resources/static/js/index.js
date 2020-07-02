var PromiseList=[ "http://localhost:8081/api/login",
                  "​http://localhost:8081/api/signup/"
                ];
const proxyurl = "https://cors-anywhere.herokuapp.com/";
async function response(url,init){
                    let PromiseCall=await fetch(url,init);
                    let data=await PromiseCall.json()
                    return data;
                    }
function displaySignUp(){
	document.getElementById("sign_up").style.display="block";
}
function displayLogin(){
	document.getElementById("login").style.display="block";
}
function closeDialog(){
	document.getElementById("sign_up").style.display="none";
	document.getElementById("login").style.display="none";
}
function displaySignUp2(){
	document.getElementById("login").style.display="none";
	document.getElementById("sign_up").style.display="block";
	//window.location.assign("/signup/")
}

function loginMsg(event){
    event.preventDefault();
    let loginEmail = document.getElementById('loginEmail').value;
    let loginPassword = document.getElementById('loginPassword').value;

    var user = {
        "user_email":loginEmail,
        "user_pass":loginPassword
    };

    var init = {
        method:'POST',
        body:JSON.stringify(user),
        headers:{
            'Content-Type':'application/json'
        }
    };
   
    response("http://localhost:8081/api/login",init)
   .then(data=>{
	   console.log(data);
            if(data.status==true){
            	localStorage.setItem("vOneLocalStorage", data.id); 
            	window.location.replace("http://localhost:8081/api/"+data.user_name+"/home");
            	
            }
            else{
            	document.getElementById("loginWarningMsg").textContent="Enter valid credentials";
            //	 console.log(data);
            }
        })
        .catch(error=>document.getElementById("loginWarningMsg").textContent="Enter valid credentials" );
        }
//	console.log(error)
//}	



async function signUp(event){
    event.preventDefault();
  /*  signupBtn.addEventListener("click", function (evt) {
        evt.preventDefault();  
    
      return false;
      });*/
    let userName = document.getElementById('username').value;
    let firstName = document.getElementById('firstname').value;
    let lastName = document.getElementById('lastname').value;
    let dob=document.getElementById('dob').value;
    let email=document.getElementById('emailId').value;
    let password=document.getElementById('passwd').value;
    let confirmPassword=document.getElementById('confirmpasswd').value;
    if(password==confirmPassword){
        var user={
            user_name: userName,
            first_name: firstName,
            last_name: lastName,
            full_name: firstName+" "+lastName,
            dob: dob,
            user_email: email,
            user_pass:password
        };

        var init = {
            method:'POST',
            body:JSON.stringify(user),
            headers:{
                'Content-Type':'application/json'
            }
        };
        
        
        
        response("http://localhost:8081/api/signup/",init)
            .then(data=>{
                        if(data.status!=true){
                            document.getElementById("signUPWarningMsg").textContent="Sign up unsuccessfull. ";
                        }
                        else{
                           if(confirm("Successfully signed up")){
                        		document.getElementById("sign_up").style.display="none";
                        		document.getElementById("login").style.display="block";
                           }
                           else
                        	   window.location.href("http://localhost:8081/api/index");
                        }
            })
            .catch(error=>console.log(error));
    }
    else{
        document.getElementById("warningMsg").textContent="Password mismatch. Please try again later";
    }

}	