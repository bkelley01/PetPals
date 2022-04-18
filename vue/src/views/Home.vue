<template>
  <div class="main">
    <img id="dog-pic-id" src="@/images/howling.gif" />
    <!-- <img id="smiling-dog" src="@/images/smiling-dog.jpg" /> -->
    <div id="view-form">
      <div id="home" class="container">
        <h1>Who We Are</h1>
        <div id="p-div">
          <p>Did you know that playtime not only increases the happiness of your fur kids, but also their owners?</p> 
          <p>Find new pals and arrange convenient playdates to build your pet's social circle.</p> 
          <p>PetPals is an interactive app and online community dedicated to helping your pets connect for real-life playdates.</p>
          <p>Fun for your four-legged friends and easy for you - register for an account or log in and start making connections with pets in your neighborhood!</p>
        </div>
      </div> 
      <!-- <div v-show="!this.$store.state.token" id="credential-form" class="container"> -->
        <div id="new-user" class="container" v-show="!this.$store.state.token">
          <h1>New Here?</h1>
          <p>We're so glad to have you join our community!</p>
          <button type="submit" id="sign-up-button"><router-link :to="{ name: 'register' }" id="register-text">Create An Account Here</router-link></button>
        </div>
        <div id="returning-user" class="container" v-show="!this.$store.state.token">
          <h1>Already Have An Account?</h1>
          <p>We're glad to see you again!</p>
          <button type="submit" id="sign-in-button"><router-link :to="{ name: 'login' }" id="register-text">Login Here</router-link></button>
        </div>
      <!-- </div> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

h1 {
  grid-area: h1;
  /* margin: 0px; */
}

/* p {
  text-align: center;
  grid-area: p;
} */

#dog-pic-id {
margin:auto; /* Required */
bottom:0; /* Aligns at the bottom */
grid-area: dog-pic;
display: block;
margin-left: auto;
margin-right: auto;
/* width: 50%; */
height: 150px;
}


#view-form {
  display: grid;
  grid-template-areas: 
  "new-user"
  "sign-up-button"
  "home"
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
  width: 250px;
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
  width: 250px;
}

#home {
  grid-area: home;
  width: 90%;
  margin: auto;
  
}

#register-text {
  color: white;
  text-decoration: none;
}

.main {
  /* border: solid 1px blue; */
}

.container {
  /* border: solid 1px red; */
}

#p-div {
  text-align: left;
}

@media only screen and (min-width: 800px) {
  #view-form {
    display: grid;
    grid-template-areas: 
    "home home"
    "new-user returning-user";

  }

  #new-user {
    grid-area: new-user;
    width: 300px;
    margin-left: auto;
    margin-right: 20px;
    margin-top: 40px;
    /* height: 100%; */
    padding: 35px;
    background-color: white;
    border-radius: 10px;
  }

  #home {
    grid-area: home;
    padding: 35px;
    background-color: white;
    border-radius: 10px;    
    width: 710px;
  }

  #returning-user {
    grid-area: returning-user;
    width: 300px;
    margin-left: 20px;
    margin-right: auto;
    margin-top: 40px;
    /* height: 100%; */
    padding: 35px;
    background-color: white;
    border-radius: 10px;
  }

  #p-div {
    text-align: left;
  }
}


</style>
