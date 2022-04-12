<template>
  <div id="login" class="text-center">
    <div class="logo">
    <!-- <img class="petpals-logo" src="@/images/petpals.png" /> -->
    <h2 class="logo-text">Connect with pets and the city around you on PetPals.</h2>
    </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div id="login-container">
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
        
        <button type="submit" id="sign-in-button" class="btn btn-primary btn-lg">Sign in</button>
        <button type="submit" id="sign-up-button"><router-link :to="{ name: 'register' }" id="register-text">Need an account?</router-link></button>
      </div>
    </form>
  </div>
</template>

<script>


import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
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
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>


<style scoped>

body {
  margin: 0;
}

#login {
  /* background-color: #F6F6F6; */
  background-color: lightseagreen;
  height: 100vh;
  margin: 0;
}

.logo {
  display: block;
}

.logo-text {
  display: block;
  text-align: center;

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

}

h1 {
  text-align: center;
}

#login-container {
  display: grid;
  grid-template-areas: 
  "username-field username-field"
  "password-field password-field"
  "sign-in-button sign-in-button"
  "sign-up-button sign-up-button";
  width: 15%;
  margin: auto;
  row-gap: 5%;
  /* height: 200px; */
  /* grid-template-rows: 49% 49%; */
}



#username-field {
  grid-area: username-field;
  /* height: 90%; */
}



#password-field {
  grid-area: password-field;
  margin-bottom: 5%;
  /* height: 90%; */
}

#sign-in-button {
  grid-area: sign-in-button;
  width: 100%;
  margin: auto;
  background-color: #3399FF;
  color: white;
  border-radius: 5px;
  height: 150%;
  border: none;
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


</style>