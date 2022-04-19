import axios from 'axios';

export default {

    getAllUsers() {
        return axios.get('/users');
    },

    getUsernameByPetId(petId) {
        return axios.get(`/users/${petId}`);
    }

}