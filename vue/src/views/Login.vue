<template>
  <div id="login" class="text-center">
    <div class="logo">
    <!-- <img class="petpals-logo" src="@/images/petpals.png" /> -->
    <h2 class="logo-text">Connect with pets and the city around you on PetPals.</h2>
    </div>
    <form class="form-signin" @submit.prevent="login">
      
      <div id="frisbee">
          <img id="frisbee-image" src="@/images/frisbee-dog.gif" />
          <!-- credit to: https://dribbble.com/shots/10496057-Dog-catching-a-frisbee -->
      </div>
      
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div id="login-container">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
        <!-- <label for="username" class="sr-only" id="username-label">Username</label> -->
        <input
          type="text"
          id="username-field"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <!-- <label for="password" class="sr-only" id="password-label">Password</label> -->
        <input
          type="password"
          id="password-field"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        
        <button type="submit" id="sign-in-button">Sign in</button>
        <button type="submit" id="sign-up-button"><router-link :to="{ name: 'register' }" id="register-text">Need an account?</router-link></button>
        
      </div>
      
    </form>
    
  </div>
</template>

<script>
import authService from "../services/AuthService";
import petService from '@/services/PetService.js';

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      userList: [],
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            
            petService.getUserPets(this.user.username).then((response) => {
              if (response.data.length === 0) {
              this.$router.push('/register');
              } else {
              this.$router.push("/");
              }
            });
          }
        })
        .catch(e => this.handleErrorResponse(e));
        // .catch(error => {
        //   const response = error.response;

        //   if (response.status === 401) {
        //     this.invalidCredentials = true;
        //   }
        // });
    },
    handleErrorResponse(error) {
      if (error) {
        alert('Unable to find matching credentials. Please try again...');
      }
    },
  },
  created() {
    this.$store.commit('UPDATE_USER_LIST');
  }
};
</script>


<style scoped>

body {
  margin: 0;
}

#login {
  background-color: #f0f2f5;
  /* height: 100vh; */
  margin: 0;
}

.logo {
  display: block;
}

.logo-text {
  display: block;
  text-align: center;
  /* padding-top: 2%; */

}

.petpals-logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 15%;
}

.form-signin {
  display: block;
  text-align: center;
  border: 50px;
  /* padding-top: 1%; */

}



#login-container {
  display: grid;
  grid-template-areas: 
  "h1"
  "username-field"
  "password-field"
  "sign-in-button"
  "sign-up-button"
  /* "frisbee"; */;
  width: 250px;
  margin: auto;
  row-gap: 5%;
  background-color: white;
  padding: 40px;
  padding-top: 20px;
  padding-bottom: 100px;
  border-radius: 10px;

  /* height: 200px; */
  /* grid-template-rows: 49% 49%; */
}

h1 {
  grid-area: h1;
  text-align: center;
}

#username-field {
  grid-area: username-field;
  border-radius: 5px;
  border-width: thin;
  height: 40px;
  border-style: solid;
  border-color: #d1d1d1;
  /* height: 90%; */
}



#password-field {
  grid-area: password-field;
  margin-bottom: 5%;
  border-radius: 5px;
  border-width: thin;
  border-style: solid;
  height: 40px;
  border-color:#d1d1d1;
  /* height: 90%; */
}

#sign-in-button {
  grid-area: sign-in-button;
  width: 100%;
  margin: auto;
  background-color: #3399FF;
  color: white;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  cursor: pointer;
  /* width: 50%; */
  /* margin-bottom: 5%; */

  /* margin: 10px 0 10px 0; */
}

#sign-up-button {
  grid-area: sign-up-button;
  margin-top: 5%;
  background-color: #42B72A;
  border-radius: 5px;
  height: 100%;
  width: 50%;
  margin-left: auto;
  margin-right: auto;
  border: none;
}

#register-text {
  color: white;
  text-decoration: none;
}

input[type="text"] {
  font-size:16px;
  padding-left: 10px;
}

input[type="password"] {
  font-size:16px;
  padding-left: 10px;
}

#frisbee {
  width: 100%;
  height: 150px;
  margin-bottom: 0px;
}

#frisbee-image {
  height: 150px;
}

h2 {
  padding: 0;
  /* padding-top: 25px; */
}


</style>