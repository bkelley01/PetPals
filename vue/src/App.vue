<template>
  <div id="app">
    <div id="nav">
      <!-- <img class="petpals-logo" src="@/images/petpals.png" /> -->
      <header-logo></header-logo>


    </div>
    <router-view />
  </div>
</template>

<script>
import headerLogo from "@/components/Header.vue"

export default {
  name: "app",
  components: {
    headerLogo
  }
}
</script>

