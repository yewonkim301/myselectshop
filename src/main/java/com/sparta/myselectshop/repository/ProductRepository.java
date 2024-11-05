package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByUser(User user, Pageable pageable);

    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId,
        Pageable pageable);
    /* select * from
        product p left join product_folder pf
            on p.id = pf.product_id
        where p.user_id = 1
            and
            pf.folder_id = 3;
    */

    /* 페이징 기능까지 하려면
        select * from
        product p left join product_folder pf
            on p.id = pf.product_id
        where p.user_id = 1
            and
            pf.folder_id = 3
        order by p.id desc
            limit 10; // 앞에 숫자 생략하고 앞에서 부터 10개만 조회 가능
            limit 10, 10; // 이렇게 쓸 경우 10(시작하는 숫자)부터 10개 조회
    */
}
