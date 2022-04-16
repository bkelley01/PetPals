<template>
  <div>
      <playdate-card v-for="playdate in filteredPlaydates" :key="playdate.playdateId" :playdate="playdate" />
  </div>
</template>

<script>
import PlaydateCard from '../profile/PlaydateCard.vue';
import playdateService from '@/services/PlaydateService.js';

export default {
    components: { PlaydateCard },
    data() {
        return {
            playdates: []
        }
    },

    created() {
        playdateService.getAllPlaydates().then(response => {
            this.playdates = response.data;
        });
    },
    
    computed: {
        filteredPlaydates() {
           return this.playdates.filter(curPlaydate => {
                let titleFilter = this.$store.state.playdateFilter.playdateTitle;
                
                if (titleFilter != "") {
                    return true;
                } else {
                     return curPlaydate.playdateTitle.includes(titleFilter);
                }

           }); 
        }
    }
}
</script>

<style>

</style>