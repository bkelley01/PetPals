import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getUserPets(username) {
      return http.get(`/pets/${username}`);
    },

    deactivatePet(petId) {
      return http.put(`pets/change-status/${petId}`);
    }

  // login(user) {
  //   return axios.post('/login', user)
  // },

  // register(user) {
  //   return axios.post('/register', user)
  // }

}
