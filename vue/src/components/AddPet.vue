<template>
  <div>
    <form class="pet-register" @submit.prevent="registerPet">
      <!-- <label for="username" class="sr-only">Username</label> -->
      <div id="register-pet-container">
        <h1 class="h3 mb-3 font-weight-normal">Add Pet</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <label class="add-pet-form-label" for="pet-name"
          >Pet Name<span class="required-star">*</span></label
        >
        <input
          type="text"
          id="pet-name"
          class="input-height"
          v-model="newPet.name"
          required
          autofocus
        />
        <!-- <label for="password" class="sr-only">Password</label> -->
        <label class="add-pet-form-label" for="personalities-list-0"
          >Personality 1</label
        >
        <select
          class="form-personalities input-height"
          name="personalities-list-0"
          v-model="newPet.personalities[0]"
        >
          <option value=""></option>
          <option value="Friendly">Friendly</option>
          <option value="Curious">Curious</option>
          <option value="Playful">Playful</option>
          <option value="Happy">Happy</option>
          <option value="Social">Social</option>
          <option value="Individualistic">Individualistic</option>
          <option value="Loyal">Loyal</option>
          <option value="Easy-going">Easy-Going</option>
          <option value="Helpful">Helpful</option>
        </select>
        <label class="add-pet-form-label" for="personalities-list-1"
          >Personality 2</label
        >
        <select
          class="form-personalities input-height"
          name="personalities-list-1"
          v-model="newPet.personalities[1]"
        >
          <option value=""></option>
          <option value="Friendly">Friendly</option>
          <option value="Curious">Curious</option>
          <option value="Playful">Playful</option>
          <option value="Happy">Happy</option>
          <option value="Social">Social</option>
          <option value="Individualistic">Individualistic</option>
          <option value="Loyal">Loyal</option>
          <option value="Easy-going">Easy-Going</option>
          <option value="Helpful">Helpful</option>
        </select>
        <label class="add-pet-form-label" for="personalities-list-2"
          >Personality 3</label
        >
        <select
          class="form-personalities input-height"
          name="personalities-list-2"
          v-model="newPet.personalities[2]"
        >
          <option value=""></option>
          <option value="Friendly">Friendly</option>
          <option value="Curious">Curious</option>
          <option value="Playful">Playful</option>
          <option value="Happy">Happy</option>
          <option value="Social">Social</option>
          <option value="Individualistic">Individualistic</option>
          <option value="Loyal">Loyal</option>
          <option value="Easy-going">Easy-Going</option>
          <option value="Helpful">Helpful</option>
        </select>
        <label class="add-pet-form-label" for="pet-type-list"
          >Pet Type<span class="required-star">*</span></label
        >
        <select
          class="form-pet-type input-height"
          name="pet-type-list"
          v-model="newPet.type"
          required
        >
          <option value=""></option>
          <option value="Dog">Dog</option>
          <option value="Cat">Cat</option>
        </select>
        <p id="required-p">* required</p>
        <button
          class="btn btn-lg btn-primary btn-block"
          type="submit"
          id="add-pet-btn"
        >
          Add Pet
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "add-pet",
  data() {
    return {
      newPet: {
        name: "",
        personalities: [],
        type: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
};
</script>

<style scoped>
#register-pet-container {
  display: flex;
  flex-direction: column;
  width: 250px;
  margin: auto;
  row-gap: 5%;
  background-color: white;
  padding: 40px;
  padding-top: 20px;

  border-radius: 10px;
}

label.add-pet-form-label {
  margin-top: 15px;
}

.input-height {
  height: 30px;
  padding: 1px 0px 1px 0px;
}

#add-pet-btn {
  width: 100%;
  margin: auto;
  background-color: #3399ff;
  margin-top: 10%;
  color: white;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  cursor: pointer;
}

#required-p {
  color: red;
  font-size: 13px;
  margin: 0px;
}

.required-star {
  color: red;
  font-size: 18px;
}

.form-pet-type {
  margin-bottom: 6px;
}
</style>