import axios from "axios";
const BASE_API_URL = "http://localhost:8080/api/v1";
const LIST_API_URL = `${BASE_API_URL}/list/`;
class ListService {
    getLists() {
        return axios.get(LIST_API_URL);
    }
}
export default new ListService();