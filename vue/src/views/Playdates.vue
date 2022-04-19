<template>
  <div>
    <div id="create-playdate-div">
      <h2>Need Your Own Playdate?</h2>
      <button id="create-playdate" @click="() => {this.$router.push('/playdates/create')}">Create Playdate</button>
    </div>

    <div id="pet-mini-cards-div">
      <pet-mini-card />
    </div>
      <div id="playdates-div">
        <div id="playdates-section-div">
          <playdates-section />
        </div>
        <div id="playdates-filter-div">
          <pets-filter/>
        </div>
      </div>
  </div>
</template>

<script>
import PlaydatesSection from '../components/playdates/PlaydatesSection.vue';
import PetsFilter from '../components/playdates/PetsFilter.vue';
import PetMiniCard from '../components/playdates/MiniPetCard.vue';

export default {
  components: {
    PlaydatesSection,
    PetsFilter,
    PetMiniCard
  }
}

</script>

<style>
#playdates-div {
  display: grid;
  grid-template-areas:
    "create-playdate-div   create-playdate-div"
    "playdates-section-div playdates-filter-div";
}

#playdates-section-div {
  grid-area: playdates-section-div;
}

#playdates-filter-div {
  grid-area: playdates-filter-div;
}

#create-playdate-div {
  grid-area: create-playdate-div;
  align-items: center;
}

#create-playdate {
    display: block;
    background-color: #3399FF;
    width: 250px;
    height: 40px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
  }

</style>