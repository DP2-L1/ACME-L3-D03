
package acme.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banner.Banner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BannerRepository extends AbstractRepository {

	@Query("select count(b) from Banner b")
	int countAdvertisements();

	@Query("select b from Banner b")
	List<Banner> findManyBannersAvailable(PageRequest pageRequest);

	@Query("select b from Banner b where b.id = :id")
	Banner findOneBannerById(int id);

	default Banner findRandomBanner() {
		Banner result;
		int count, index;
		ThreadLocalRandom random;
		boolean isAvailable = false;
		PageRequest page;
		List<Banner> list = new ArrayList<>();
		Banner banner;

		count = this.countAdvertisements();
		if (count == 0)
			result = null;
		else {
			while (isAvailable == false) {
				random = ThreadLocalRandom.current();
				index = random.nextInt(0, count);

				page = PageRequest.of(index, 1);
				list = this.findManyBannersAvailable(page);
				banner = this.findOneBannerById(list.get(0).getId());
				isAvailable = banner.isAvailable();
			}
			result = list.isEmpty() ? null : list.get(0);
		}
		return result;
	}
}
