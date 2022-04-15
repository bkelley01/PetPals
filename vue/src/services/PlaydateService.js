import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getUserPlaydates(username) {
      return http.get(`/playdates/${username}`);
    }

  // login(user) {
  //   return axios.post('/login', user)
  // },

  // register(user) {
  //   return axios.post('/register', user)
  // }

}
