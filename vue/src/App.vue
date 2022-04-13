<template>
  <div id="app">
  <div id="nav">
      <header-text></header-text>
  </div>
    <add-pet />
    <router-view />
  </div>
</template>

<script>
import headerText from "@/components/Header.vue"
import addPet from '@/components/AddPet.vue'

export default {
  name: "app",
  components: {
    headerText,
    addPet
  }, 
  data() {
    return {
      showMenu: false
    }
  },
  
}
</script>
