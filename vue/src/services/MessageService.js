import axios from 'axios';

export default {

    getAllMessages() {
        return axios.get('/messages');
    }
}