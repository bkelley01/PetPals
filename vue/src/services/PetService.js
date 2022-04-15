import axios from 'axios';

// const http = axios.create({
//   baseURL: "http://localhost:8080"
// });

export default {

    getUserPets(username) {
      return axios.get(`/pets/${username}`);
    },

    deactivatePet(petId) {
      return axios.put(`pets/${petId}`);
    }

  // login(user) {
  //   return axios.post('/login', user)
  // },

  // register(user) {
  //   return axios.post('/register', user)
  // }

}
