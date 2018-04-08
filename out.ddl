
    drop table if exists public.test_entity cascade

    create table public.test_entity (
       id varchar(255) not null,
        abc_route_usaprice boolean not null,
        age int4,
        amount numeric(19, 2),
        created_by timestamp,
        enabled boolean not null,
        local_date date,
        updated_by timestamp,
        primary key (id)
    )
