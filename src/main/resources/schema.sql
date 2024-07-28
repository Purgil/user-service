CREATE SCHEMA IF NOT EXISTS public;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO purgil_master;

-- UserEntity 테이블 생성
CREATE TABLE IF NOT EXISTS "user" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL,
    is_withdrawn BOOLEAN NOT NULL,
    withdrawn_at TIMESTAMP,
    created_by VARCHAR(255),
    created_at TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_at TIMESTAMP
);

-- SocialProfileEntity 테이블 생성
CREATE TABLE IF NOT EXISTS social_profile (
    id BIGSERIAL PRIMARY KEY,
    social_id VARCHAR(255) NOT NULL,
    social_type VARCHAR(50) NOT NULL,
    additional_info JSONB,
    created_at TIMESTAMP
);

-- FollowEntity 테이블 생성
CREATE TABLE IF NOT EXISTS follow (
    id BIGSERIAL PRIMARY KEY,
    follower_id UUID NOT NULL,
    following_id UUID NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (follower_id) REFERENCES "user" (id),
    FOREIGN KEY (following_id) REFERENCES "user" (id)
);

-- BlockEntity 테이블 생성
CREATE TABLE IF NOT EXISTS block (
    id BIGSERIAL PRIMARY KEY,
    blocker_id UUID NOT NULL,
    blocking_id UUID NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (blocker_id) REFERENCES "user" (id),
    FOREIGN KEY (blocking_id) REFERENCES "user" (id)
);
