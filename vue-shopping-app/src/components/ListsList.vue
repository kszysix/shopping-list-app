<template>
  <div class="container">
    <h3 class="text-center mb-4 mt-4">Items</h3>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Content</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in items" v-bind:key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.content }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import ListService from "@/services/ListService";
export default {
  name: "ListsList",
  data() {
    return {
      items: [],
    };
  },
  methods: {
    getLists() {
      ListService.getLists()
          .then(response => {
            this.items = response.data;
          });
    }
  },
  created() {
    this.getLists();
  }
};
</script>
<style>
</style>