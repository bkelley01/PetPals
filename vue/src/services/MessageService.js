import axios from 'axios';

export default {

    getAllMessages() {
        return axios.get('/messages');
    },

    createMessage(message) {
        return axios.post('/messages', message);
    }
}