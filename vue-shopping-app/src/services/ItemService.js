import axios from "axios";
const BASE_API_URL = "http://localhost:8080/api/v1";
const ITEM_API_URL = `${BASE_API_URL}/item/`;
class ItemService {
    getItems() {
        return axios.get(ITEM_API_URL);
    }
}
export default new ItemService();