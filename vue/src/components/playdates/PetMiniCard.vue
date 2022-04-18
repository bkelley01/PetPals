<template>
    <div>
        
        <h3 v-for="pet in filteredPets" v-bind:key="pet.petId" v-bind:pet="pet">{{ pet.petName }}
            <i v-if="pet.petType === 'Dog'" class="fas fa-dog"></i>
            <i v-if="pet.petType === 'Cat'" class="fas fa-cat"></i>
        </h3>
        <div id="pet-details">
            <p><i class="far fa-user"></i>{{pet.username}}</p>
            <p v-on:click="showPlaydates = !showPlaydates">Playdates</p>
            
            
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            showPlaydates: false
        }
    }

}
</script>

<style>

</style>