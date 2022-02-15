create table users
(
    id         bigserial primary key,
    name       text not null,
    surname    text not null,
    password   text not null,
    email      text unique not null,
    created_at timestamp default now()
);

create table admins
(
    id         bigserial primary key,
    name       text not null,
    surname    text not null,
    password   text not null,
    email      text unique not null,
    created_at timestamp default now()
);

create table categories
(
    id         bigserial primary key,
    name       text unique not null
);

create table products
(
    id         bigserial primary key,
    name       text unique not null,
    price      float not null,
    brand      text not null,
    specification_id bigint references specifications(id) on delete cascade,
    category_id bigint references categories(id)
);

create table specifications
(
    id          bigserial primary key,
    description text,
    category_id bigint references categories(id),
    product_id  bigint references products(id) on delete cascade,
    s_diagonal text,
    OS text,
    cores_number int,
    memory int,
    m_camera text,
    f_camera text,
    bluetooth text,
    nfc boolean,
    fast_charge boolean,
    wireless_charge boolean,
    housing_material text,
    weight text,
    guarantee text,
    screen_refresh_rate text,
    RAM text,
    drive_type text,
    video_card_manufacturer text,
    work_time text,
    color text
);
