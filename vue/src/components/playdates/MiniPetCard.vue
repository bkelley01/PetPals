<template>
    <div id="mini-pet-card-container">
        <h3>{{pet.petName}}</h3>
        <p id="para-id" class="para"><i class="far fa-user"></i> {{owner}} </p>
        <p class="para"><i class="fas fa-paw"></i> <span v-if="pet.petType === 'Dog'">Dog</span>
            <span v-else><i class="fas fa-cat"></i>Cat</span>
        </p>
        <p class="para" @click="showPlaydates = !showPlaydates" id="pet-playdates-list">Playdates: {{playdates.length}}</p>
        <ul v-if="showPlaydates === true">
            <li v-for="playdate in playdates" :key="playdate.playdateId" >{{playdate.playdateTitle}}</li>
        </ul>
        <!-- <h3>

            v-for="pet in filteredPets" v-bind:key="pet.petId" v-bind:pet="pet"
            Pet Name
            <i v-if="pet.petType === 'Dog'" class="fas fa-dog"></i>
            <i v-if="pet.petType === 'Cat'" class="fas fa-cat"></i>
        </h3>
        <div id="pet-details">
            <p><i class="far fa-user"></i>{{pet.username}}</p>
            <p v-on:click="showPlaydates = !showPlaydates">Playdates</p>
            
            
        </div> -->
    </div>
</template>

<script>
import petService from '@/services/PetService.js';
import userService from '@/services/UserService.js';

export default {
    name: "mini-pet-card",
    props: ["pet"],
    data() {
        return {
            showPlaydates: false,
            playdates: [],
            owner: ""
        }
    },

    created() {
        petService.getPlaydatesByPetId(this.pet.petId).then(response => {
            this.playdates = response.data;
        });

        userService.getUsernameByPetId(this.pet.petId).then(response => {
            this.owner = response.data;
        });
    }

}
</script>

<style>


#pet-playdates-list {
    text-decoration: underline;
    cursor: pointer;
}

#mini-pet-card-container {
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  width: 80%;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  border: 1px solid #d1d1d1;
}

.para {
    margin: 8px 0px;
}

#para-id {
    margin-top: 15px;
}


@media screen and (min-width: 768px) {
    #mini-pet-card-container {
        width: 300px;
    }
}

</style>