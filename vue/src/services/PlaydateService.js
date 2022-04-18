import axios from 'axios';

export default {

    getUserPlaydates(username) {
      return axios.get(`/playdates/${username}`);
    },

    getAllPlaydates() {
      return axios.get('/playdates');
    },

    createPlaydate(playdate) {
      return axios.post('/playdates', playdate);
    }
}
