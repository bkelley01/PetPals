import axios from 'axios';

export default {

    getUserPets(username) {
      return axios.get(`/pets/${username}`);
    },

    deactivatePet(petId) {
      return axios.put(`pets/${petId}`);
    },

    addPet(pet) {
      return axios.post(pet);
    }

}
