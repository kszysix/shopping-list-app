<template>
  <div className="container">
    <MainApp/>
  </div>
</template>
<script>

import MainApp from "@/components/MainApp";

export default {
  name: 'VueShoppingApp',
  components: {
    MainApp,
  }
}
</script>
<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>