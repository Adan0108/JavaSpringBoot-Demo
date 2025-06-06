package com.adan108.repository;

import com.adan108.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)

public interface UserRepository extends JpaRepository<UserEntity,Long> , JpaSpecificationExecutor<UserEntity> {
    //use pageable
    Page<UserEntity> findByUserName(String name, Pageable pageable);
    Page<UserEntity> findByUserNameContaining(String name, Pageable pageable);

    //customise JPA
    //find username vs usernameEmail
    //Step 1 :findByUserNameAndUserEmail
    //Step 2 :UserNameAndUserEmail
    //Step 3 :userNameAndUserEmail
    //Step 4 :where userName = ?1 and userEmail = ?2

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    UserEntity findByUserName(String userName);

    /**
     * WHERE userName Like ?%
     */
    List<UserEntity> findByUserNameStartingWith(String userEmail);

    /**
     * WHERE userName Like ?%
     */
    List<UserEntity> findByUserNameEndingWith(String userEmail);

    /**
     * WHERE userName < 1
     */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    /**
     * UPDATE DELETE
     */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query
    /**
     * get count user use native query
     */

    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}
