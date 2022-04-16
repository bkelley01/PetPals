import axios from 'axios';

export default {

    getUserPets(username) {
      return axios.get(`/pets/${username}`);
    },

    deactivatePet(petId) {
      return axios.put(`pets/${petId}`);
    },

    addPet(pet) {
      return axios.post('/pets', pet);
    },

    addPetToPlaydate(petId, playdateId) {
      return axios.post(`/pet-playdate/${petId}/${playdateId}`);
    }

}
