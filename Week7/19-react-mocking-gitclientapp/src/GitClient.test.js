
import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyData = {
      data: [
        { name: "Repo1" },
        { name: "Repo2" },
        { name: "Repo3" }
      ]
    };

    axios.get.mockResolvedValue(dummyData);

    const repos = await GitClient.getRepositories("techiesyed");
    expect(repos).toEqual(["Repo1", "Repo2", "Repo3"]);
  });
});
