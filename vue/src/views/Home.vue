<template>
  <div class="home">
    <h1>What We Are</h1>
    <p>PatPals is an interactive app and online community dedicated to helping your pet connect with other pets for real-life playdates.</p>
    <!-- <img class="dog-pic" src="@/images/labrador.webp" /> -->
    <img class="dog-pic" src="@/images/howling.gif" />
    <div id="credential-form">
      <div id="new-user">
        <h1>New Here?</h1>
        <p>We're so glad to have you join our community!</p>
        <button type="submit" id="sign-up-button"><router-link :to="{ name: 'register' }" id="register-text">Create An Account Here</router-link></button>
      </div>
      <div id="returning-user">
        <h1>Already Have An Account?</h1>
        <p>We're glad to see you again!</p>
        <button type="submit" id="sign-in-button"><router-link :to="{ name: 'login' }" id="register-text">Login Here</router-link></button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

.home {
display: grid;
grid-template-areas: 
"dog-pic"
"h1"
"p";
align-content: center;
}

h1 {
  grid-area: h1;
  /* margin: 0px; */
}

p {
  text-align: center;
  grid-area: p;
}

.dog-pic {
   margin:auto; /* Required */
 bottom:0; /* Aligns at the bottom */
 left:0;right:0; /* Aligns horizontal center */
 max-height:50%; /* images bigger than 175 px  */
 max-width:50%;  /* will be shrinked to size */ 
 grid-area: dog-pic;
}

#credential-form {
  display: grid;
  grid-template-areas: 
  "new-user"
  "sign-up-button"
  "returning-user"
  "sign-in-button";
  text-align: center;
}

#new-user {
grid-area: new-user;
}

#returning-user {
grid-area: returning-user;
}

#sign-up-button {
  grid-area: sign-in-button;
  width: 20%;
  margin: auto;
  background-color: #3399FF;
  color: white;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  text-align: center;
  text-decoration: none;
}

#sign-in-button {
  grid-area: sign-in-button;
  width: 20%;
  margin: auto;
  background-color: #3399FF;
  color: white;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  text-align: center;
  text-decoration: none;
}

/* 
.home{
    background-image: url('https://media.giphy.com/media/0IGRygDt5cMP2Q0Jmu/giphy.gif');
    background-size: cover;
    
    
    
    height: 100vh;
    padding:0;
    margin:0;
} */


</style>
