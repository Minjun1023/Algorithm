select
    count(*) as count
from
    ECOLI_DATA
where
    GENOTYPE & 2 = 0 -- 2번 형질을 갖지 않으면서
    -- 1번 형질을 갖거나 3번 형질을 갖는 경우
    AND (GENOTYPE & 1 = 1 OR GENOTYPE & 4 = 4)